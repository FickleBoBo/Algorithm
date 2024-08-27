package day_21.BOJ_G4_16434;

import java.io.*;
import java.util.*;

public class Main {

    static class Room{
        int type;
        long atk;
        long hp;

        public Room(int type, long atk, long hp) {
            this.type = type;
            this.atk = atk;
            this.hp = hp;
        }
    }

    static class Hero{
        long heroMaxHP;
        long heroCurHP;
        long heroAtk;

        public Hero(long heroMaxHP, long heroAtk) {
            this.heroMaxHP = heroMaxHP;
            this.heroCurHP = heroMaxHP;
            this.heroAtk = heroAtk;
        }

        public boolean fight(long monsHP, long monsAtk){
            long heroAtkCnt = monsHP / heroAtk;
            if(monsHP % heroAtk > 0) heroAtkCnt += 1;

            long monsAtkCnt = heroCurHP / monsAtk;
            if(heroCurHP % monsAtk > 0) monsAtkCnt += 1;

            if(heroAtkCnt > monsAtkCnt){
                return false;
            }
            else{
                heroCurHP -= monsAtk * (heroAtkCnt - 1);
                return true;
            }
        }

        public void drinkPotion(long potionHP, long potionAtk){
            heroCurHP = Math.min(heroCurHP + potionHP, heroMaxHP);
            heroAtk += potionAtk;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long heroAtk = Integer.parseInt(st.nextToken());
        Room[] input = new Room[N];

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            long atk = Integer.parseInt(st.nextToken());
            long hp = Integer.parseInt(st.nextToken());

            input[i] = new Room(type, atk, hp);
        }

        long ans = binarySearchLowerBound(heroAtk, N, input);

        System.out.println(ans);
    }

    private static long binarySearchLowerBound(long heroAtk, int N, Room[] input){
        long left = 1;
        long right = Long.MAX_VALUE - 1;

        while(left < right){
            long heroMaxHP = left / 2 + right / 2;

            boolean flag = true;
            Hero hero = new Hero(heroMaxHP, heroAtk);

            for(int i=0 ; i<N ; i++){
                if(input[i].type == 1){
                    if(!hero.fight(input[i].hp, input[i].atk)){
                        flag = false;
                        break;
                    }
                }
                else{
                    hero.drinkPotion(input[i].hp, input[i].atk);
                }
            }

            if(!flag){
                left = heroMaxHP + 1;
            }
            else{
                right = heroMaxHP;
            }
        }

        return right;
    }

}
