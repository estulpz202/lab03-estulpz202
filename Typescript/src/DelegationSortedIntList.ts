import { IntegerList } from './IntegerList'
import { SortedIntList } from './hidden/SortedIntListLibrary.js'

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

class DelegationSortedIntList implements IntegerList {
  private readonly sortedList: SortedIntList = new SortedIntList()
  private totalAdded: number = 0

  add (num: number): boolean {
    this.totalAdded++
    return this.sortedList.add(num)
  }

  addAll (list: IntegerList): boolean {
    this.totalAdded += list.size()
    return this.sortedList.addAll(list)
  }

  getTotalAdded (): number {
    return this.totalAdded
  }

  get (index: number): number {
    return this.sortedList.get(index)
  }

  remove (num: number): boolean {
    return this.sortedList.remove(num)
  }

  removeAll (list: IntegerList): boolean {
    return this.sortedList.removeAll(list)
  }

  size (): number {
    return this.sortedList.size()
  }
}

export { DelegationSortedIntList }
