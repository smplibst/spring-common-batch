package com.smplibst.spring.batch;

import com.smplibst.commons.core.exception.core.ErrorCode;
import com.smplibst.commons.core.exception.core.ErrorCodeExceptionIF;
import com.smplibst.commons.core.exception.core.ErrorCodeRuntimeException;

/**
 * バッチ処理用例外クラス.<br>
 * @author atsushi.matsumoto
 * @since 1.0.0
 */
public class BatchException extends ErrorCodeRuntimeException {

    /**
     * serialVersionUID.<br>
     * @since X.X.X
     */
    private static final long serialVersionUID = -688175239635125890L;

    /**
     * 終了コード.<br>
     * @since X.X.X
     */
    private ExitCode exitCode;

    /**
     * コンストラクタ.<br>
     * @param errorCode エラーコード
     * @param exitCode 終了コード
     * @since 1.0.0
     */
    public BatchException(ErrorCode errorCode, ExitCode exitCode) {
        super(errorCode);
        this.exitCode = exitCode;
    }

    /**
     * コンストラクタ.<br>
     * @param errorCode エラーコード
     * @param exitCode 終了コード
     * @param cause 例外
     * @since 1.0.0
     */
    public BatchException(ErrorCode errorCode, ExitCode exitCode, Throwable cause) {
        super(errorCode, cause);
        this.exitCode = exitCode;
    }

    /**
     * コンストラクタ.<br>
     * @param other 内包させる例外
     * @param exitCode 終了コード
     * @since 1.0.0
     */
    public BatchException(ErrorCodeExceptionIF other, ExitCode exitCode) {
        super(other);
        this.exitCode = exitCode;
    }

    /**
     * 置換データを設定する.<br>
     * @param args 置換データ
     * @return 自身のインスタンス
     * @since 1.0.0
     */
    public BatchException setArgs(Object... args) {
        super.setArgs(args);
        return this;
    }

    /**
     * 終了コードを取得する.<br>
     * @return 終了コード
     * @since 1.0.0
     */
    public ExitCode getExitCode() {
        return this.exitCode;
    }
}
