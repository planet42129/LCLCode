package com.yhh.practice.exam.hw0424;

import java.util.*;

/**
 * @author hyh
 * @date 2024/4/24
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] s1Arr = s1.split(" ");
        int playerNum = Integer.parseInt(s1Arr[0]);
        int shutNum = Integer.parseInt(s1Arr[1]);
        String[] s2Arr = s2.split(" ");// 4个队员对应的射击情况
        Player[] players = new Player[playerNum];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(0, 0, new ArrayList<>(), 0);
        }
        for (int i = 0; i < playerNum; i++) {
            setPlayerInfo(players[i], s2Arr[i], i + 1);
        }
       /* Map<Player, Integer> map = new TreeMap<>((o1, o2) -> {
            if (o1.hits != o2.hits) {
                return o2.hits - o1.hits;//逆序
            }
            if (o1.continuous != o2.continuous) {
                return o2.continuous - o1.continuous;//逆序
            }
            for (int i = 0; i < o1.failPos.size(); i++) {
               if (o1.failPos.get(i) != o2.failPos.get(i)) {
                   return o2.failPos.get(i) - o1.failPos.get(i);// 逆序
               }
            }
            return o1.id - o2.id;//正序
        });
        for (Player player :
                players) {
            map.put(player, player.getId());
        }

        for (Map.Entry<Player, Integer> playerIntegerEntry : map.entrySet()) {
            int value = playerIntegerEntry.getValue().intValue();
            System.out.println(value + " ");
        }*/
        Arrays.sort(players, (o1, o2) -> {
            if (o1.hits != o2.hits) {
                return o2.hits - o1.hits;//逆序
            }
            if (o1.continuous != o2.continuous) {
                return o2.continuous - o1.continuous;//逆序
            }
            for (int i = 0; i < o1.failPos.size(); i++) {
               if (o1.failPos.get(i) != o2.failPos.get(i)) {
                   return o2.failPos.get(i) - o1.failPos.get(i);// 逆序
               }
            }
            return o1.id - o2.id;//正序
        });
        for (Player player :
                players) {
            System.out.print(player.getId());
        }
    }
    private static Player setPlayerInfo(Player player, String s, Integer id) {
        player.setId(id);
        int hits = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                hits++;
            } else { // 不为1
                player.failPos.add(i);
            }
        }
        player.setHits(hits);
        int maxContinious = 0;
        int subLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                subLen++;
            } else {
                subLen = 0;
            }
            if (subLen > maxContinious) {
                maxContinious = subLen;
            }
        }
        player.setContinuous(maxContinious);
        return player;
    }
}

class Player {
    int hits;
    int continuous;
    List<Integer> failPos;
    int id;

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setContinuous(int continuous) {
        this.continuous = continuous;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player() {
    }
    public Player(int hits, int continuous, List<Integer> failPos, int id) {
        this.hits = hits;
        this.continuous = continuous;
        this.failPos = failPos;
        this.id = id;
    }

}