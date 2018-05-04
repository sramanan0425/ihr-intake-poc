import sbt.Keys._
import play.sbt.PlayImport
import play.sbt.PlayImport.PlayKeys._
import Dependencies._
import com.rallyhealth.sbt.{RallyDockerSbtPlugin, RallyKamonPlugin}
import sbt._

name := "ihrintake"

organizationName in ThisBuild := "Rally Health"
organization in ThisBuild := "com.rallyhealth.ihrintake"

rallyVersioningSnapshotLowerBound in ThisBuild := "1.0.0"

resolvers in ThisBuild += rallyArtifactoryLibSnapshotsResolver.value

//NOTE: remove the package model from this regex once they are functional and tests are written
val standardPlayCoverageExclude = "<empty>;Reverse.*;router\\.*;.*models.*"

scalacOptions in ThisBuild := Seq(
  "-Xlint",
  "-feature",
  "-deprecation:false",
  "-unchecked",
  "-Xfuture",
  "-Ywarn-nullary-override",
  "-Ywarn-inaccessible",
  "-Ywarn-adapted-args"
)

lazy val root = (project in file("."))
  .aggregate(web, models)


lazy val models = (project in file("models"))
  .enablePlugins(SemVerPlugin)
  .settings(
    name := "ihrintake-models",
    coverageEnabled in Test := true,
    publishArtifact := true,
    publishArtifact in Test := false,
    // Workaround to prevent race conditions in DB tests
    parallelExecution in Test := false,
    libraryDependencies ++= Seq(

      Ext.macWireMacros,
      Ext.macWireProxy,
      Ext.macWireUtil,
      Ext.mockito,
      Ext.playJsonExt,
      Ext.playJsonNaming,
      Ext.playSlickLib,
      Ext.scalaCheck,
      Ext.scalaLogging,
      Ext.scalaTestPlus,
      PlayImport.jdbc,
      Rally.libSpartanPlay25Json,
      Rally.libCareStatsDatadog,
      Rally.libCareStatsPlay25,
      Rally.libEnigmaPlay25,
      Rally.libIlluminatiPlay25,
      Rally.libPostgres,
      Rally.scalacheckOps,
      Ext.Play25.enumeratum,
      Ext.Play25.enumeratumPlayJson
    )
  )



lazy val web = (project in file("web"))
  .enablePlugins(RallyDockerSbtPlugin)
  .enablePlugins(RallyKamonPlugin)
  .enablePlugins(PlayScala)
  .dependsOn(
    models
  )
  .aggregate(
    models
  )
  .configs(config("it") extend Test)
  .settings(Defaults.itSettings: _*)
  .settings(
    name := "ihrintake",
    rallyDockerAppImageName := "core/ihrintake",
    // check out - https://gist.github.com/htmldoug/254af1b3fc34c4159f0d6839116d354b
    rallyDockerAppJavaAgents += JavaAgent(Ext.aspectJWeaver, autoEnable = true),
    coverageEnabled in Test := true,
    publishArtifact := true,
    publishArtifact in Test := false,
    coverageExcludedPackages := standardPlayCoverageExclude, // all excludes get concatenated here
    scalacOptions ++= Seq("-Xlint:-missing-interpolator"), // -xlint doesn't play well with the routes file
    libraryDependencies ++= Seq(
      // app dependencies, keep alpha
      Ext.akkaMockScheduler,
      Ext.logback,
      Ext.macWireMacros,
      Ext.macWireProxy,
      Ext.macWireUtil,
      Ext.mockito,
      Ext.playSlickLib,
      Ext.scalaLogging,
      Ext.scalaTestPlus,
      PlayImport.jdbc,
      PlayImport.evolutions,
      Rally.libHttpInterceptorPlay25Bundle,
      Rally.libCorrelationKamonLogging,
      Rally.libCareStatsDatadog,
      Rally.libCareStatsPlay25,
      Rally.libEnigmaPlay25,
      Rally.libIlluminatiPlay25,
      Rally.libOptumMempe,
      Rally.libPostgres,
      Rally.libSpartanPlay25Json,
      Rally.playJsonTests,
      Rally.playTestOps,
      Ext.postgresDriver,
      Rally.playModuleOpsMonitor,
      Rally.scalacheckOps,
      Ext.libLogbackClassic,
      Ext.h2Database
    )
  )



scalaVersion := "2.11.11"
updateOptions := updateOptions.value.withLatestSnapshots(false)


