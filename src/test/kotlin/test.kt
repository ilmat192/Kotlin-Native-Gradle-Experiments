import kotlin.test.*

@Test
fun test() {
    assertEquals(expected(), return42())
}

@Test
@Ignore
fun wrongTest() {
    assertEquals(43, return42())
}