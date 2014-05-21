/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ages.tool;

import entity.AgesCard;

/**
 *
 * @author mark
 */
public class AgesCardForArrayList extends AgesCard {

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ca.add(new AgesCard(").append(getSeq()).append(",");
        sb.append("").append(getId()).append(",");
        sb.append("\"").append(getName()).append("\",");
        sb.append("").append(getAge()).append(",");
        sb.append("\"").append(getCivilMilitary()).append("\",");
        sb.append("\"").append(getTag()).append("\",");
        sb.append("\"").append(getAction()).append("\",");
        sb.append("\"").append(getIconPoints()).append("\",");
        sb.append("\"").append(getEffect()).append("\",");
        sb.append("\"").append(getCost()).append("\",");
        sb.append("\"").append(getColor()).append("\",");
        sb.append("").append(getCnt()).append(",");
        sb.append("").append(getTokenWhite()).append(",");
        sb.append("").append(getTokenRed()).append(",");
        sb.append("").append(getTokenYellow()).append(",");
        sb.append("").append(getTokenBlue()).append(",");
        sb.append("").append(getEffectWhite()).append(",");
        sb.append("").append(getEffectFood()).append(",");
        sb.append("").append(getEffectRed()).append(",");
        sb.append("").append(getEffectMusic()).append(",");
        sb.append("").append(getEffectStone()).append(",");
        sb.append("").append(getEffectIdea()).append(",");
        sb.append("").append(getEffectSmile()).append(",");
        sb.append("").append(getEffectHouse()).append(",");
        sb.append("").append(getEffectBlue()).append(",");
        sb.append("").append(getEffectWeapon()).append(",");
        sb.append("").append(getEffectWeaponOld()).append(",");
        sb.append("").append(getEffectYellow()).append(",");
        sb.append("").append(getCostPeople()).append(",");
        sb.append("").append(getCostFoot()).append(",");
        sb.append("").append(getCostWonder()).append(",");
        sb.append("").append(getCostMilitary()).append(",");
        sb.append("").append(getCostHorse()).append(",");
        sb.append("").append(getCostCannon()).append(",");
        sb.append("").append(getCostPeace()).append(",");
        sb.append("").append(getCostRevolution()).append(",");
        sb.append("").append(getCostRed()).append(",");
        sb.append("").append(getCostStone()).append(",");
        sb.append("").append(getCostIdea()).append(",");
        sb.append("").append(getCostFood()).append(",");
        sb.append("").append(getCostMusic()).append("));");

        return toString();
    }
}
