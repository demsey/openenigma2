require gdb-cross.inc
inherit cross

PR = "r3"

SRC_URI += "file://early_debug_in_nptl.patch;patch=1;pnum=0"

