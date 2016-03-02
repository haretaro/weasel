package com.github.haretaro.weasel.role

import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Talk

/**
 * @author Haretaro
 */
class Villager extends BasePlayer{

  override def talk(): String = Talk.OVER

  override def vote(): Agent = null

  override def divine(): Agent = null

  override def attack(): Agent = null

  override def guard(): Agent = null

  override def whisper(): String = null

  override def finish(): Unit = ()

}