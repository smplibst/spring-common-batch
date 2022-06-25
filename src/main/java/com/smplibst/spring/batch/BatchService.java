package com.smplibst.spring.batch;

/**
 * バッチサービスクラス.<br>
 * @author atsushi.matsumoto
 * @since X.X.X
 */
public interface BatchService {

    /**
     * 実行メソッド.<br>
     * @throws Exception 処理で異常が発生した場合にスローされる。
     * @since X.X.X
     */
    void execute() throws Exception;
}
