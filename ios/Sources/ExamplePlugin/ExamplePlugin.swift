import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(ExamplePlugin)
public class ExamplePlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "ExamplePlugin"
    public let jsName = "Example"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "readNfc", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = Example()

    @objc func readNfc(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.readNfc(value)
        ])
    }
}
