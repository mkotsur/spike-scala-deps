package io.github.mkotsur.greeter

import cats.effect.IO
import io.github.mkotsur.user.{LanguagePref, User}

object Greeter {

  type Greeter = User => IO[Unit]

  def languageAwareGreeter(language: LanguagePref): Greeter =
    user => {
      val line = language match {
        case LanguagePref.French  => s"Bonjour, ${user.name}"
        case LanguagePref.English => s"Hello, ${user.name}"
      }
      IO(println(line))
    }

}

trait Greeter {

  // When should your dependency go as a function param in the trait?
  // When should your dependency go as a function param in the comp. obj?
  def greet(user: User): IO[Unit]

}
