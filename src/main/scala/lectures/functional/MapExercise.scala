package lectures.functional

object MapExercise extends App {

  /**
   * overly simplified social network:
   * Person = String
   * - add a person to the network
   * - remove
   * - friend (mutual)
   * - unfriend
   *
   * - number of friends
   * - person with most friends
   * - how many people have no friends
   * - if there is a social connection between two people
   */

  //our definition
  type Person = String
  type SocialNetwork = Map[Person, Set[Person]]
  var socialNetwork: SocialNetwork = Map()

  def addPerson(network: SocialNetwork, person: Person): SocialNetwork = network + (person -> Set())

  def friend(network: SocialNetwork, a: Person, b: Person): SocialNetwork = {
    val friendsOfA = network(a)
    val friendsOfB = network(b)

    network + (a -> (friendsOfA + b)) + (b -> (friendsOfB + a))
  }

  socialNetwork = addPerson(socialNetwork, "Dave")
  socialNetwork = addPerson(socialNetwork, "Kevin")
  socialNetwork = addPerson(socialNetwork, "Levi")

  println(socialNetwork)

  socialNetwork = friend(socialNetwork, "Levi", "Kevin")

  println(socialNetwork)

}
