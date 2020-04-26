package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-26 3:16 오후
 *
 * by 키워드를 이용한 위임은 interface의 구현체만 위임 활 수 있다.
 * 일반 클래스를 위임하는 것은 안된다.
 */

interface DelegationInterface {
    fun findByName(name: String): String
    fun findAll(): List<String>
}

class DelegationImpl(var name: String) : DelegationInterface {
    override fun findByName(name: String) = name;
    override fun findAll() = listOf(name, "kimchanjung")
}

/**
 * 실제적으로는 DelegationInterface 의 구현체 는를 위임 받는 것
 * 이라고 보면된다  open 키워드가 없어 상속 할 수 없는 DelegationImpl를 위임하여
 * 상속의 효과를 누린다
 */
class DelegationByImpl(private val delegationInterface: DelegationInterface,
                       var name: String) : DelegationInterface
by delegationInterface {
    override fun findAll() = listOf(name, "kimchanjung", "mogomezwai")
}


/**
 * 일반적인 방식 의 MutableList interface 구현체
 * 모든 메소드를 구현해야한다.
*/
class NewList<T>(override val size: Int, init: (index: Int) -> T): MutableList<T> {
    private val list = ArrayList<T>(size)

    init {
        repeat(size) { index -> list.add(init(index)) }
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): T {
        println("NewList - override get")
        return list.get(index)
    }

    override fun indexOf(element: T): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<T> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: T): Int {
        TODO("Not yet implemented")
    }

    override fun add(element: T): Boolean {
        println("NewList - override add")
        list.add(element)
        return true
    }

    override fun add(index: Int, element: T) {
        TODO("Not yet implemented")
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun listIterator(): MutableListIterator<T> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        TODO("Not yet implemented")
    }

    override fun remove(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAt(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun set(index: Int, element: T): T {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        TODO("Not yet implemented")
    }

}

/**
 * 위임을 사용한 경우는
 * 모든 메소드를 오버라이드 할 필요 없다.
 *
 */
class DelegateList<T>(override val size: Int, private val ml: MutableList<T> = mutableListOf(), init: (index: Int) -> T) : MutableList<T> by ml {

    init {
        repeat(size) { index -> ml.add(init(index)) }
    }

    override fun add(element: T): Boolean {
        println("DelegateList - override add")
        return ml.add(element)
    }
}