package com.github.haretaro.weasel.role

import org.aiwolf.client.base.player.AbstractRoleAssignPlayer

/**
 * @author Haretaro
 */
class Weasel extends AbstractRoleAssignPlayer{
  
  setVillagerPlayer(new Villager)
  override def getName:String = "Weasel"
}