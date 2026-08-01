#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(git rev-parse --show-toplevel)"
TARGET="${1:-$(date +%Y-%m)}"
CO_AUTHOR="${2:-Claude Code}"

if [[ ! "$TARGET" =~ ^[0-9]{4}-(0[1-9]|1[0-2])$ ]]; then
  echo "invalid month format: $TARGET (expected YYYY-MM)" >&2
  exit 1
fi

MODULE_DIR="$REPO_ROOT/$TARGET"

if [[ -e "$MODULE_DIR" ]]; then
  echo "already exists: $MODULE_DIR — nothing to do" >&2
  exit 1
fi

mkdir -p "$MODULE_DIR/src"

MODULE_CONTENT=$(cat <<'EOF'
<?xml version="1.0" encoding="UTF-8"?>
<module type="JAVA_MODULE" version="4">
  <component name="NewModuleRootManager" inherit-compiler-output="true">
    <exclude-output />
    <content url="file://$MODULE_DIR$">
      <sourceFolder url="file://$MODULE_DIR$/src" isTestSource="false" />
    </content>
    <orderEntry type="inheritedJdk" />
    <orderEntry type="sourceFolder" forTests="false" />
  </component>
</module>
EOF
)
printf '%s' "$MODULE_CONTENT" > "$MODULE_DIR/$TARGET.iml"

MODULES_XML="$REPO_ROOT/.idea/modules.xml"
if [[ -f "$MODULES_XML" ]]; then
  MODULE_LINE="      <module fileurl=\"file://\$PROJECT_DIR\$/$TARGET/$TARGET.iml\" filepath=\"\$PROJECT_DIR\$/$TARGET/$TARGET.iml\" />"
  awk -v line="$MODULE_LINE" '{ if ($0 ~ /<\/modules>/) print line; print }' "$MODULES_XML" > "$MODULES_XML.tmp"
  mv "$MODULES_XML.tmp" "$MODULES_XML"
else
  echo "warning: $MODULES_XML not found, skipped registration" >&2
fi

cd "$REPO_ROOT"
git add "$TARGET/$TARGET.iml"
git commit -m "$(printf 'chore: %s 모듈 세팅\n\nCo-Authored-By: %s <noreply@anthropic.com>' "$TARGET" "$CO_AUTHOR")"

echo "done: $TARGET"
