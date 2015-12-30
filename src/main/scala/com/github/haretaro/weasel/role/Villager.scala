package com.github.haretaro.weasel.role

import com.github.haretaro.weasel.common.BasePlayer
import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Talk
import org.aiwolf.common.net._
import scala.collection.convert.WrapAsScala._

/**
 * @author Haretaro
 */
class Villager extends BasePlayer{

  override def talk:String = Talk.SKIP

  override def vote:Agent = null

  override def divine(): Agent = null

  override def attack(): Agent = null

  override def guard(): Agent = null

  override def whisper(): String = null
}