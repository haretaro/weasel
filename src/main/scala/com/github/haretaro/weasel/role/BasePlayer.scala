package com.github.haretaro.weasel.role

import com.github.haretaro.weasel.informationManagement.{GameInformation, DailyInformation}
import org.aiwolf.client.base.player.AbstractRole
import org.aiwolf.common.data.Agent
import org.aiwolf.common.net.{GameInfo, GameSetting}


/**
  * @author Haretaro
  */
trait BasePlayer extends AbstractRole{

  var dailyInformation: DailyInformation = null
  var gameInformation: GameInformation = null

  override def dayStart(): Unit = {
    dailyInformation = new DailyInformation
  }

  override def finish(): Unit = ()

  override def initialize(gameInfo: GameInfo, gameSetting: GameSetting): Unit = {
    dailyInformation = new DailyInformation
    gameInformation = GameInformation(gameInfo.getAgent)
  }

  override def update(gameInfo: GameInfo): Unit = {
    dailyInformation.update(gameInfo)
    gameInformation.update(gameInfo)
  }

}
