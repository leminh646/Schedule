class Employee:
    def __init__(self, name):
        self.name = name
        self.preferences = {}  # {day: shift}
        self.workdays = 0

    def set_preference(self, day, shift):
        self.preferences[day] = shift