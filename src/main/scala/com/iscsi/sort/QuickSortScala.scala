package com.iscsi.sort

/**
  * Created by hkatz on 6/2/16.
  */
object QuickSortScala {
  def sortFunction(xs: List[Int]): List[Int] = {
    xs match {
      case Nil => Nil
      case  pivot :: tail =>
        val (lessthan, morethan) = tail.partition(_ < pivot)
        sortFunction(lessthan) ::: pivot :: sortFunction(morethan)
    }
  }

  def sortFunctional(xs: List[Int]): List[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      val (lessthan, combined) = xs.partition(_ < pivot)
      val (pivotList, morethan) = combined.partition(_ == pivot)
      sortFunctional(lessthan) ++ pivotList ++ sortFunctional(morethan)
    }
  }

  def sortTraditionl(xs: Array[Int]) {
    def swap(i: Int, j: Int) {
      val t = xs(i)
      xs(i) = xs(j)
      xs(j) = t
    }

    def sort1(l: Int, r: Int) {
      val pivot = xs((l + r) / 2)
      var i = l
      var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }
    sort1(0, xs.length - 1)
  }

  def timeCheck(t1: Long, l: Seq[Int], t2: Long, caption: String) =
    println(s"$caption style : ${t2 - t1} : ${l.take(100).mkString(",")}")

  def main(args: Array[String]): Unit = {
    val n = if (args.length == 1) args(0).toInt else 100
    val l = List.fill(n) { scala.util.Random.nextInt(n - 1) }

    val arr = l.toArray

    timeCheck(System.nanoTime, sortFunction(l), System.nanoTime, "Functional1")
    timeCheck(System.nanoTime, sortFunctional(l), System.nanoTime, "Functional2")
    timeCheck(System.nanoTime, {sortTraditionl(arr); arr}, System.nanoTime, "Traditional2")
  }
}
