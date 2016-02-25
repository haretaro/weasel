package com.github.haretaro.weasel.role

import com.github.haretaro.weasel.informationManagement.{GameInformation, DailyInformation}
import org.aiwolf.client.base.player.AbstractRole
import org.aiwolf.common.net.{GameInfo, GameSetting}


/**
  * @author Haretaro
  */
trait BasePlayer extends AbstractRole{

  var dailyInformation = new DailyInformation
  var gameInformation = new GameInformation

  override def initialize(gameInfo: GameInfo, gameSetting: GameSetting): Unit = {
    dailyInformation = new DailyInformation
    gameInformation = new GameInformation
  }

  override def dayStart(): Unit = {
    dailyInformation = new DailyInformation
  }

  override def finish: Unit = ()

  override def update(gameInfo: GameInfo): Unit = {
    dailyInformation.update(gameInfo)
    gameInformation.update(gameInfo)
  }

}
