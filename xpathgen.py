import clipboard as c

firstPart = input("Enter first part of OP: ")

while True:
    secondPart = input("Enter second part of OP: ")
    xpath = input("Enter XPath of OP: ")
    clip = firstPart + "." + secondPart + ".XPath=" + xpath
    #send clip to clipboard
    c.copy(clip)
    input("Click enter to copy declaration: ")
    declaration = "public static final String CMP_" + firstPart.upper() + "_" + secondPart.upper() + " = " + '"' + firstPart + "." + secondPart + "." + "XPath" + '";'
    c.copy(declaration)
    #send declaration to clipboard
