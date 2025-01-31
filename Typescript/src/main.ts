
/**
 * Main class for Recitation 5. This can be used as sandbox to experiment in.
 * @author Nora Shoemaker
 *
 */

import { DelegationSortedIntList } from './DelegationSortedIntList.js'
import { IntegerList } from './IntegerList.js'

const list1: DelegationSortedIntList = new DelegationSortedIntList()
const list2: DelegationSortedIntList = new DelegationSortedIntList()

// add 5 elements to our first list.
list1.add(1)
list1.add(3)
list1.add(2)
list1.add(4)
list1.add(2)

printList(list1)
console.log(list1.getTotalAdded())

// add 2 elements to a second list.
list2.add(3)
list2.add(0)

// add the first list (5 elements) to our second list (2 elements).
list2.addAll(list1)

printList(list2)
console.log(list2.getTotalAdded())

/**
  * A helper function that prints out the contents of an IntegerList.
  * @param list IntegerList to be printed out.
  */
function printList (list: IntegerList): void {
  console.log()
  for (let i = 0; i < list.size(); i++) {
    process.stdout.write(list.get(i).toString())
    process.stdout.write(', ')
  }
  console.log()
}

export { printList }
