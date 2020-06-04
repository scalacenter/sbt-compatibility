package sbtcompatibility

import coursier.version.{ModuleMatchers, VersionCompatibility}
import lmcoursier.CoursierConfiguration
import sbt._
import sbt.librarymanagement.{DependencyResolution, ScalaModuleInfo, UpdateConfiguration, UnresolvedWarningConfiguration}
import sbt.librarymanagement.DependencyBuilders.OrganizationArtifactName

trait SbtCompatibilityKeys {
  final val compatibilityPreviousArtifacts      = taskKey[Seq[ModuleID]]("")
  final val compatibilityReportDependencyIssues = taskKey[Unit]("")
  final val compatibilityCheck                  = taskKey[Unit]("Runs both compatibilityReportDependencyIssues and mimaReportBinaryIssues")

  final val compatibilityReconciliations         = taskKey[Seq[ModuleID]]("")
  final val compatibilityIgnored                 = taskKey[Seq[OrganizationArtifactName]]("")
  final val compatibilityDetailedReconciliations = taskKey[Seq[(ModuleMatchers, VersionCompatibility)]]("")
  final val compatibilityCheckDirection          = taskKey[Direction]("")

  final val compatibilityFindDependencyIssues = taskKey[Seq[(ModuleID, DependencyCheckReport)]]("")

  final val compatibilityCsrConfiguration               = taskKey[CoursierConfiguration]("CoursierConfiguration instance to use to fetch previous versions dependencies")
  final val compatibilityDependencyResolution           = taskKey[DependencyResolution]("DependencyResolution instance to use to fetch previous versions dependencies")
  final val compatibilityUpdateConfiguration            = taskKey[UpdateConfiguration]("")
  final val compatibilityUnresolvedWarningConfiguration = taskKey[UnresolvedWarningConfiguration]("")
  final val compatibilityScalaModuleInfo                = taskKey[Option[ScalaModuleInfo]]("")

  final val compatibilityIgnoreSbtDefaultReconciliations = taskKey[Boolean]("")
  final val compatibilityUseCsrConfigReconciliations     = taskKey[Boolean]("")
  final val compatibilityDefaultReconciliation           = taskKey[VersionCompatibility]("")

  final val compatibilityAutoPreviousArtifacts     = taskKey[Seq[ModuleID]]("")
  final val compatibilityPreviousArtifactsFromMima = taskKey[Seq[ModuleID]]("")
  final val compatibilityPreviousVersions          = taskKey[Seq[String]]("")
}