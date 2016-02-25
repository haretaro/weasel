package com.github.haretaro.weasel.role

import com.github.haretaro.weasel.informationManagement.DailyInformation
import org.aiwolf.client.base.player.AbstractRole
import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Talk
import org.aiwolf.common.net._
import scala.collection.convert.WrapAsScala._

/**
 * @author Haretaro
 */
class Villager extends AbstractRole{

  var dailyInformation = new DailyInformation

  override def initialize(gameInfo: GameInfo, gameSetting: GameSetting): Unit = {
    dailyInformation = new DailyInformation
  }

  override def talk:String = Talk.OVER

  override def update(gameInfo: GameInfo): Unit = {
    dailyInformation.update(gameInfo)
    println(gameInfo.getDay,dailyInformation.potentialCandidate)
  }

  override def vote:Agent = null

  override def divine(): Agent = null

  override def attack(): Agent = null

  override def guard(): Agent = null

  override def whisper(): String = null

  override def finish(): Unit = ()

  override def dayStart(): Unit = {
    dailyInformation = new DailyInformation
  }
}