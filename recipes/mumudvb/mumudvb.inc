DESCRIPTION = "redistributes streams from DVB on a network using multicast or HTTP unicast"
MAINTAINER = "Andreas Oberritter <obi@opendreambox.org>"

SRC_URI = "http://mumudvb.braice.net/mumudvb/mumudvb-${PV}/mumudvb_${PV}.tar.gz"

S = "${WORKDIR}/mumudvb"

inherit autotools

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}

