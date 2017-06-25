package com.cpxiao.optical.illusions.spiral.eye.mode;

/**
 * Extra
 *
 * @author cpxiao on 2016/8/31
 */
public final class Extra {

    /**
     * Intent或Bundle的name
     */
    public static final class Name {
        /**
         * 游戏模式
         */
        public static final String GAME_MODE = "GAME_MODE";

        /**
         * 关卡
         */
        public static final String LEVEL = "LEVEL";
    }

    /**
     * SharedPreferences 的key
     */
    public static final class Key {
        /**
         * 关卡，默认为1
         */
        public static final int LEVEL_DEFAULT = 1;
        public static final String LEVEL = "LEVEL";

        /**
         * 最高分，默认为0分
         */
        public static final int BEST_SCORE_DEFAULT = 0;
        public static final String BEST_SCORE = "BEST_SCORE";

    }

}
