/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ages.tool;

import entity.AgesCard;
import entity.AgesCardJpaController;
import entity.Card;
import entity.CardJpaController;
import entity.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import ws.Card;

/**
 *
 * @author mark
 */
public class ToolCardToAgesCardStatement {

    EntityManagerFactory emf;
    CardJpaController control1;
    AgesCardJpaController control2;
    List<AgesCard> agesList;

    public ToolCardToAgesCardStatement() {
        emf = Persistence.createEntityManagerFactory("agesPU");
        control1 = new CardJpaController(emf);
        control2 = new AgesCardJpaController(emf);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ToolCardToAgesCardStatement tool = new ToolCardToAgesCardStatement();
        tool.cleanUpAgesCard();
        tool.createAgesCard();
        tool.showStatementsForArrayList();
    }

    private void showStatementsForArrayList() {
//        List<  AgesCard> list2;
//        list2 = control2.findAgesCardEntities();

        for (AgesCard card : agesList) {
            showStatement(card);
        }
    }

    public void showStatement(AgesCard card) {
        StringBuilder sb = new StringBuilder();
        sb.append("ca.add(new AgesCard(").append(card.getSeq()).append(",");
        sb.append("").append(card.getId()).append(",");
        sb.append("\"").append(card.getName()).append("\",");
        sb.append("").append(card.getAge()).append(",");
        sb.append("\"").append(card.getCivilMilitary()).append("\",");
        sb.append("\"").append(card.getTag()).append("\",");
        sb.append("\"").append(card.getAction()).append("\",");
        sb.append("\"").append(card.getIconPoints()).append("\",");
        sb.append("\"").append(card.getEffect()).append("\",");
        sb.append("\"").append(card.getCost()).append("\",");
        sb.append("\"").append(card.getColor()).append("\",");
        sb.append("").append(card.getCnt()).append(",");
        sb.append("").append(card.getTokenWhite()).append(",");
        sb.append("").append(card.getTokenRed()).append(",");
        sb.append("").append(card.getTokenYellow()).append(",");
        sb.append("").append(card.getTokenBlue()).append(",");
        sb.append("").append(card.getEffectWhite()).append(",");
        sb.append("").append(card.getEffectFood()).append(",");
        sb.append("").append(card.getEffectRed()).append(",");
        sb.append("").append(card.getEffectMusic()).append(",");
        sb.append("").append(card.getEffectStone()).append(",");
        sb.append("").append(card.getEffectIdea()).append(",");
        sb.append("").append(card.getEffectSmile()).append(",");
        sb.append("").append(card.getEffectHouse()).append(",");
        sb.append("").append(card.getEffectBlue()).append(",");
        sb.append("").append(card.getEffectWeapon()).append(",");
        sb.append("").append(card.getEffectWeaponOld()).append(",");
        sb.append("").append(card.getEffectYellow()).append(",");
        sb.append("").append(card.getCostPeople()).append(",");
        sb.append("").append(card.getCostFoot()).append(",");
        sb.append("").append(card.getCostWonder()).append(",");
        sb.append("").append(card.getCostMilitary()).append(",");
        sb.append("").append(card.getCostHorse()).append(",");
        sb.append("").append(card.getCostCannon()).append(",");
        sb.append("").append(card.getCostPeace()).append(",");
        sb.append("").append(card.getCostRevolution()).append(",");
        sb.append("").append(card.getCostRed()).append(",");
        sb.append("").append(card.getCostStone()).append(",");
        sb.append("").append(card.getCostIdea()).append(",");
        sb.append("").append(card.getCostFood()).append(",");
        sb.append("").append(card.getCostMusic()).append("));");

        System.out.println(sb.toString());

    }

    private void createAgesCard() throws NonexistentEntityException, Exception {

        List<  Card> list1;
//        List<  AgesCard> list2;
        list1 = control1.findCardEntities();
        System.out.println("Card size = " + list1.size());
//        list2 = control2.findAgesCardEntities();
//        System.out.println("AgesCard size = " + list2.size());
        AgesCard agesCard=new AgesCard();
        int seq = 0;

        for (Card card : list1) {
            agesCard = new AgesCard();
            agesCard.setId(card.getId());
            agesCard.setName(card.getName());
            agesCard.setAction(card.getAction());
            agesCard.setEffect(card.getEffect());
            agesCard.setIconPoints(card.getIconPoints());
            agesCard.setAge(card.getAge());
            agesCard.setCivilMilitary(card.getCivilMilitary());
            agesCard.setTag(card.getTag());
            agesCard.setColor(card.getColor());

            agesCard = updateEffectAndIconPoints(agesCard);
            for (int num = 0; num < card.getCnt(); num++) {
//                control2.create(agesCard);
                seq++;
                agesCard.setSeq(seq);
                AgesCard copy=agesCard.copy();
                System.out.print(" "+seq);
                System.out.println(" "+agesCard.getSeq());
                agesList.add(copy);
            }
        }
//        list2 = control2.findAgesCardEntities();
        System.out.println("AgesCard in ArrayList size = " + agesList.size());

    }
//  

    private void cleanUpAgesCard() throws NonexistentEntityException {
  agesList=new ArrayList<>();
    return;
//        Card agesCard= control1.findCard(1001);
//        System.out.println(" "+agesCard.getName()+ " "+agesCard.getTokenWhite());
//   
//        List<  AgesCard> list;
//        list = control2.findAgesCardEntities();
//        System.out.println("AgesCard  before size = " + list.size());
//
//        for (AgesCard agesCard : list) {
//            control2.destroy(agesCard.getSeq());
//        }
//        list = control2.findAgesCardEntities();
//        System.out.println("AgesCard  after size = " + list.size());

    }

    private AgesCard parseCardEffect(AgesCard card) {
        String[] tokens = card.getEffect().split(";");
        for (String token : tokens) {
            if (token.trim().length() == 0) {
                continue;
            }
//            System.out.println(""+token);
            String[] pair = token.split(":");
            String key = pair[0];
            int val = Integer.parseInt(pair[1]);
//            System.out.println(key + " " + val);

//            Effect keyword: [+黃點, +白點, +紅點, 石頭, 燈泡, 笑臉, 食物, 過期武器, +房屋, 音樂, +藍點, 武器]
            switch (key) {
                case "+黃點":
                    card.setEffectYellow(val);
                    break;
                case "+白點":
                    card.setEffectWhite(val);
                    break;
                case "+紅點":
                    card.setEffectRed(val);
                    break;
                case "+藍點":
                    card.setEffectBlue(val);
                    break;
                case "+房屋":
                    card.setEffectHouse(val);
                    break;
                case "食物":
                    card.setEffectFood(val);
                    break;
                case "音樂":
                    card.setEffectMusic(val);
                    break;
                case "石頭":
                    card.setEffectStone(val);
                    break;
                case "燈泡":
                    card.setEffectIdea(val);
                    break;
                case "笑臉":
                    card.setEffectSmile(val);
                    break;
                case "藍點":
                    card.setEffectBlue(val);
                    break;
                case "武器":
                    card.setEffectWeapon(val);
                    break;
                case "過期武器":
                    card.setEffectWeaponOld(val);
                    break;
                default:
                    System.out.println("***************NEED TO HANDLE => " + key);

            }

        }
        return card;
    }

    private AgesCard parseIconPoints(AgesCard card) {
//        int counter=0;
        String[] tokens = card.getIconPoints().split(";");
        for (String token : tokens) {
            if (token.trim().length() == 0) {
                continue;
            }
//            System.out.println(""+token);
            String[] pair = token.split(":");
            String key = pair[0];
            int val = -999;
            try {
                if (key.equals("奇蹟石頭")) {
                    val = 98765;
                } else {

                    val = Integer.parseInt(pair[1]);
                }
            } catch (Exception ex) {
                System.out.println(card.getId() + " IconPoints is " + card.getIconPoints());

                System.out.println("token is ###" + token + "###");
                ex.printStackTrace();
                System.exit(-1);
            }
//            System.out.println(key + " " + val);

//            Effect keyword: [+黃點, +白點, +紅點, 石頭, 燈泡, 笑臉, 食物, 過期武器, +房屋, 音樂, +藍點, 武器]
            switch (key) {
                case "擴充人口":
                    card.setCostPeople(val);
                    break;
                case "步":
                    card.setCostFoot(val);
                    break;
                case "奇蹟石頭":
                    card.setCostWonder(val);
                    break;
                case "軍事牌":
                    card.setCostMilitary(val);
                    break;
                case "馬":
                    card.setCostHorse(val);
                    break;
                case "炮":
                    card.setCostCannon(val);
                    break;
                case "和平燈炮":
                    card.setCostPeace(val);
                    break;
                case "革命燈泡":
                    card.setCostRevolution(val);
                    break;
                case "消耗紅點":
                    card.setCostRed(val);
                    break;
                case "石頭":
                    card.setCostStone(val);
                    break;
                case "燈泡":
                    card.setCostIdea(val);
                    break;
                case "食物":
                    card.setCostFood(val);
                    break;
                case "音樂":
                    card.setCostMusic(val);
                    break;

                default:
                    System.out.println("***************NEED TO HANDLE => " + key);
                    System.exit(-1);
            }
        }
        return card;
    }

    private AgesCard updateEffectAndIconPoints(AgesCard card) throws Exception {
        if (card.getEffect().length() > 0) {
            parseCardEffect(card);
        }
        if (card.getIconPoints().length() > 0) {
            parseIconPoints(card);
        }

        return card;
    }
}
