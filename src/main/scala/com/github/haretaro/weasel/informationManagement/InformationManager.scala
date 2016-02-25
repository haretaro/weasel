package com.github.haretaro.weasel.informationManagement

import org.aiwolf.common.net.GameInfo

/**
  * Created by Haretaro on 2016/02/24.
  */
trait InformationManager {
  def update(gameInfo: GameInfo): Unit
}
