export interface ExamplePlugin {
  readNfc(options: { value: string }): Promise<{ value: string }>;
}
