import sbt._
import Keys._

/***************************************************************************************
 * The whole of project for build file by sbt.
 * 该文件为项目的总控编译文件.
 * 在 Common.scala 和 Dependencies.scala 中定义 使用scalal的编译版本、依赖的lib包、资源库与去重策略。
 * 1.Common.scala 文件中定义:
 * 		1).使用scalal的编译版本
 *      2).资源库
 *      3).去重策略
 * 2.Dependencies.scala 文件中定义:
 * 		1).jar的依赖与依赖关系
 *		2).打包策略
 *
 * @createdTime 2017-07-13 14:34:27
 * @author yangwunan
 ***************************************************************************************/
object MyBuild extends Build {

  import Dependencies._
  import Common._

  val NamePrefix = "IBM-"
}