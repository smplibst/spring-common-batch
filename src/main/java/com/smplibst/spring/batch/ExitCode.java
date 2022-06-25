package com.smplibst.spring.batch;

/**
 * 終了コード用インターフェース.<br>
 * @author atsushi.matsumoto
 * @since 1.0.0
 */
public interface ExitCode {

    /**
     * デフォルト終了コード[正常].<br>
     * @since X.X.X
     */
    ExitCode DEFAULT_SUCCESS_CODE = new ExitCode() {

        /**
         * {@inheritDoc}
         * @see com.smplibst.spring.batch.ExitCode#getCode()
         * @since X.X.X
         */
        public int getCode() {
            return 0;
        }
    };

    /**
     * デフォルト終了コード[異常].<br>
     * @since X.X.X
     */
    ExitCode DEFAULT_ERROR_CODE = new ExitCode() {

        /**
         * {@inheritDoc}
         * @see com.smplibst.spring.batch.ExitCode#getCode()
         * @since X.X.X
         */
        public int getCode() {
            return 1;
        }
    };

    /**
     * 終了コードを取得する.<br>
     * @return 終了コード
     * @since 1.0.0
     */
    int getCode();
}
