package acyclic.plugin
import acyclic.file
import tools.nsc.Global

class Plugin(val global: Global, cycleReporter: Seq[Seq[(String, Set[Int])]] => Unit) extends tools.nsc.plugins.Plugin {

  val name = "Acyclic"
  val description = "Allows the developer to prohibit inter-file dependencies"

  val components = List[tools.nsc.plugins.PluginComponent](
    new PluginPhase(this.global, cycleReporter)
  )
}
