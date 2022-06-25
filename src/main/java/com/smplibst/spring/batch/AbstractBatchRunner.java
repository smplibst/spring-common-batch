package com.smplibst.spring.batch;

import java.lang.management.ManagementFactory;

import org.slf4j.MDC;
import org.springframework.boot.CommandLineRunner;

import com.smplibst.commons.core.logger.Logger;

/**
 * バッチ処理用親クラス.<br>
 * @author atsushi.matsumoto
 * @since 1.0.0
 */
public abstract class AbstractBatchRunner implements CommandLineRunner {

    /**
     * ロガー.<br>
     * @since 1.0.0
     */
    private Logger logger = Logger.getLogger(getClass());

    /**
     * {@inheritDoc}
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     * @since 1.0.0
     */
    @Override
    public void run(String... args) throws Exception {

        // プロセスIDを設定する。
        MDC.put("pid", ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

        long start = System.currentTimeMillis();
        ExitCode exitCode = ExitCode.DEFAULT_SUCCESS_CODE;
        try {
            // 開始ログ
            this.logger.info(">> Batch Start. process is " + this.getProcessName());

            // 処理実行
            this.process(args);
        } catch (Throwable cause) {
            this.logger.error("batch process is failure.", cause);
            if (cause instanceof BatchException) {
                // 例外に設定されている終了コードを取得する。
                exitCode = ((BatchException) cause).getExitCode();
            } else {
                // サブクラスでオーバーライドされている可能性があるので、メソッドから取得する。
                exitCode = this.getErrorExitCode();
            }
        } finally {
            // 終了ログ
            this.logger.info("<< Batch Finished.[" + exitCode.getCode() + "](" + (System.currentTimeMillis() - start) + "ms.)");
            // 処理を終了する。
            System.exit(exitCode.getCode());
        }
    }

    /**
     * プロセス名を取得する.<br>
     * @return プロセス名
     * @since 1.0.0
     */
    protected abstract String getProcessName();

    /**
     * 実際の処理を実行する.<br>
     * @param args コマンドライン引数
     * @throws Exception 処理で異常が発生した場合にスローされる。
     * @since 1.0.0
     */
    protected abstract void process(String[] args) throws Exception;

    /**
     * エラー時の終了コードを取得する.<br>
     * @return エラー時の終了コード
     * @since 1.0.0
     */
    protected ExitCode getErrorExitCode() {
        return ExitCode.DEFAULT_ERROR_CODE;
    }

    /**
     * ロガーを取得する.<br>
     * @return ロガー
     * @since 1.0.0
     */
    protected Logger getLogger() {
        return this.logger;
    }
}
