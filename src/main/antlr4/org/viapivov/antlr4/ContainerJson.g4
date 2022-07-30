grammar ContainerJson;

container: classEntries EOF;

classEntries: '{' classEntry? (',' classEntry)* '}';

classEntry:
	alias ':' '{' className (',' jsonObject)? '}';

className: CLASS_NAME ':' name;

alias: STRING;

name: STRING;

jsonObject: (keyValuePair (',' keyValuePair)*)?;

keyValuePair: STRING ':' (( STRING | NUMBER | BOOL ) | '{' jsonObject '}');

CLASS_NAME: ('"className"' | '\'className\'');

STRING: SINGLE_STRING | DOUBLE_STRING;

PRIMITIVE: STRING | NUMBER;

NUMBER: [0-9]+;

SINGLE_STRING: '\'' ~('\'')+ '\'';

DOUBLE_STRING: '"' ~('"')+ '"';

BOOL: ('true' | 'false');

WS: [ \t\r\n]+ -> skip;
