package com.github.haretaro.weasel.role

import com.github.haretaro.weasel.informationManagement.DailyInformation
import org.aiwolf.client.base.player.AbstractRole
import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Talk
import org.aiwolf.common.net._

/**
 * @author Haretaro
 */
class Villager extends BasePlayer{

  override def talk:String = Talk.OVER

  override def vote:Agent = null

  override def divine(): Agent = null

  override def attack(): Agent = null

  override def guard(): Agent = null

  override def whisper(): String = null

  override def finish(): Unit = ()

}