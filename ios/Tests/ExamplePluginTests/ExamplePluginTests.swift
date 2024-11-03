import XCTest
@testable import ExamplePlugin

class ExampleTests: XCTestCase {
    func testReadNfc() {
        // This is an example of a functional test case for a plugin.
        // Use XCTAssert and related functions to verify your tests produce the correct results.

        let implementation = Example()
        let value = "Hello, World!"
        let result = implementation.readNfc(value)

        XCTAssertEqual(value, result)
    }
}
