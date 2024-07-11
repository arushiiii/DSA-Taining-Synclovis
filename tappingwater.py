class WaterTap:
    def __init__(self, flow_rate):
        self.flow_rate = flow_rate  # in liters per second
        self.is_open = False

    def open_tap(self):
        self.is_open = True
        print("Tap is now open.")

    def close_tap(self):
        self.is_open = False
        print("Tap is now closed.")

    def get_water_flow(self, time_seconds):
        if self.is_open:
            return self.flow_rate * time_seconds
        else:
            return 0

# Example usage:
if __name__ == "__main__":
    # Create a WaterTap object with a flow rate of 0.5 liters per second
    tap = WaterTap(0.5)

    # Open the tap
    tap.open_tap()

    # Get water flow for 10 seconds
    flow = tap.get_water_flow(10)
    print(f"Water flowed: {flow} liters")

    # Close the tap
    tap.close_tap()
