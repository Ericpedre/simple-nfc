import Foundation

@objc public class Example: NSObject {
    @objc public func readNfc(_ value: String) -> String {
        print(value)
        return value
    }
}
