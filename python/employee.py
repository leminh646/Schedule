# preference stored in a list of length 7
# index 0 is Sunday and 6 is Saturday
# MS is morning shift
# AS is afternoon shift
# ES is evening shift
# days are represented as the first 3 letters (ex. 'mon' for Monday)

class Employee:
    def __init__(self, name):
        self.name = name
        self.preferences = {}  # {day: shift}
        self.workdays = 0

    def set_preference(self, day, shift):
        self.preferences[day] = shift