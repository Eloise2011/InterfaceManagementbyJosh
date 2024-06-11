package elo.pra.utils;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:39
 */
public class HouseMetadataUtil {
    public static String getStatusDescription(String status) {
        switch (status) {
            case "0":
                return "未纳入预售";
            case "1":
                return "回迁房";
            case "2":
                return "自用房";
            case "3":
                return "公建配套";
            case "4":
                return "直管房";
            case "5":
                return "分成";
            case "6":
                return "抵押";
            case "7":
                return "查封";
            case "8":
                return "已签约";
            case "9":
                return "已备案";
            default:
                return "状态有误";
        }
    }
    private static String getStatusFigure(String status) {
        switch (status) {
            case "0":
                return "★";
            case "1":
                return "△";
            case "2":
                return "□";
            case "3":
                return "☆";
            case "4":
                return "▲";
            case "5":
                return "〓";
            case "6":
                return "◆";
            case "7":
                return "●";
            case "8":
                return "◎";
            case "9":
                return "■";
            default:
                return "❌";
        }
    }
}
