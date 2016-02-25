package com.github.haretaro.weasel.informationManagement

import org.aiwolf.common.net.GameInfo

/**
  * このトレイトを継承したクラスで情報を管理する
  * @author Haretaro
  */
trait InformationManager {

  /**
    * updateの時にBasePlayerクラスが呼ぶメソッド
    */
  def update(gameInfo: GameInfo): Unit
}
