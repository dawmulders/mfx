/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.design.typography;




/**
 *
 * @author DMulders
 */
public enum MaterialTypography {
    H1, H2, H3, H4, H5, H6, SUB1, SUB2, BODY, BODY2, CAPTION, OVERLINE, BUTTON;



    public static MaterialTypography[] getTypes() {
        return new MaterialTypography[]{
            H1, H2, H3, H4, H5, H6, SUB1, SUB2, BODY, BODY2, BUTTON, CAPTION, OVERLINE
        };
    }



    public static String getFullName(MaterialTypography typo) {
        switch (typo) {
            case H1:
                return "Headline 1";
            case H2:
                return "Headline 2";
            case H3:
                return "Headline 3";
            case H4:
                return "Headline 4";
            case H5:
                return "Headline 5";
            case H6:
                return "Headline 6";
            case SUB1:
                return "Subtitle 1";
            case SUB2:
                return "Subtitle 2";
            case BODY:
                return "Body 1";
            case BODY2:
                return "Body 2";
            case CAPTION:
                return "Caption";
            case OVERLINE:
                return "OVERLINE";
            case BUTTON:
                return "BUTTON";
        }
        return "Body";
    }
}
