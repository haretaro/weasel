scalaVersion := "2.11.7"

//mainClass in (Compile, run) := Some("org.aiwolf.server.bin.RoleRequestStarter")
//mainClass in (Compile, run) := Some("org.aiwolf.client.ui.bin.GUIRoleRequestStarter")

lazy val roleClass = "com.github.haretaro.weasel.Weasel"

lazy val villager = taskKey[Unit]("play as villager")
villager := (runMain in Compile).toTask(" org.aiwolf.server.bin.RoleRequestStarter -n 16 -c "+roleClass + " VILLAGER").value

lazy val medium = taskKey[Unit]("play as medium")
medium := (runMain in Compile).toTask(" org.aiwolf.server.bin.RoleRequestStarter -n 16 -c "+roleClass + " MEDIUM").value

lazy val mediumgui = taskKey[Unit]("play as medium with gui")
mediumgui := (runMain in Compile).toTask(" org.aiwolf.client.ui.bin.GUIRoleRequestStarter -n 16 -c "+roleClass + " MEDIUM").value
