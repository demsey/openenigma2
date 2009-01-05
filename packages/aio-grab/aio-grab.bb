DESCRIPTION="AiO screen grabber for dreambox stbs"
LICENSE = "GPL"

PR = "r0"
PV = "0.8+cvs${SRCDATE}"
SRCDATE = "20081212"
SRC_URI="cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/aio-grab;module=aio-grab;method=pserver"

S = "${WORKDIR}/aio-grab"

inherit autotools pkgconfig
