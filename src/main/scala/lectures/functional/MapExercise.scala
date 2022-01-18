package lectures.functional

import scala.annotation.tailrec

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

  def unfriend(network: SocialNetwork, a: Person, b: Person): SocialNetwork = {
    val friendsOfA = network(a)
    val friendsOfB = network(b)

    network + (a -> (friendsOfA - b)) + (b -> (friendsOfB - a))
  }

  def remove(network: SocialNetwork, personToRemove: Person): SocialNetwork = {
    def removeFriends(friends: Set[Person], networkAcc: SocialNetwork): SocialNetwork = {
      if (friends.isEmpty) networkAcc
      else removeFriends(friends.tail, unfriend(networkAcc, friends.head, personToRemove))
    }

    removeFriends(network(personToRemove), network) - personToRemove
  }

  def mostFriends(network: SocialNetwork): Person = {
    network.maxBy(pair => pair._2.size)._1
  }

  def nPeopleWithNoFriends(network: SocialNetwork): Int = {
    network.count(_._2.isEmpty)
    //network.filter(_._2.isEmpty).size
  }

  //if a and b are connected
  def socialConnection(network: SocialNetwork, a: Person, b: Person): Boolean = {

    @tailrec
    def bfs(target: Person, consideredPeople: Set[Person], discoveredPeople: Set[Person]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else if (target == discoveredPeople.head) true
      else if (consideredPeople.contains(discoveredPeople.head)) bfs(target, consideredPeople, discoveredPeople.tail)
      else bfs(target, consideredPeople + discoveredPeople.head, discoveredPeople.tail ++ network(discoveredPeople.head))
    }

    bfs(b, Set(), network(a) + a)
  }

  socialNetwork = addPerson(socialNetwork, "Dave")
  socialNetwork = addPerson(socialNetwork, "Kevin")
  socialNetwork = addPerson(socialNetwork, "Levi")

  println(socialNetwork)

  socialNetwork = friend(socialNetwork, "Levi", "Kevin")

  println(socialNetwork)

  socialNetwork = unfriend(socialNetwork, "Levi", "Kevin")

  println(socialNetwork)

  socialNetwork = friend(socialNetwork, "Dave", "Kevin")
  socialNetwork = friend(socialNetwork, "Dave", "Kevin")
  socialNetwork = friend(socialNetwork, "Kevin", "Levi")

  println(socialNetwork)

  socialNetwork = remove(socialNetwork, "Dave")

  println(socialNetwork)

  socialNetwork = addPerson(socialNetwork, "Dave")
  socialNetwork = addPerson(socialNetwork, "Mark")
  socialNetwork = addPerson(socialNetwork, "Stacey")
  socialNetwork = addPerson(socialNetwork, "Mary")
  socialNetwork = addPerson(socialNetwork, "Loner1")
  socialNetwork = addPerson(socialNetwork, "Loner2")

  socialNetwork = friend(socialNetwork, "Dave", "Mary")
  socialNetwork = friend(socialNetwork, "Dave", "Stacey")
  socialNetwork = friend(socialNetwork, "Dave", "Mark")

  println(mostFriends(socialNetwork))

  println(nPeopleWithNoFriends(socialNetwork))

  println(socialConnection(socialNetwork, "Dave", "Mary"))
  println(socialConnection(socialNetwork, "Loner1", "Mary"))
}
