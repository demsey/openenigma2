DESCRIPTION = "OpenDreambox: DVB API v3 Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

PROVIDES = "\
  task-opendreambox-dvbapi \
  ${PACKAGES}\
"

#
# task-opendreambox-dvbapi3
#
RPROVIDES_${PN} = "task-opendreambox-dvbapi"
DESCRIPTION_${PN} = "OpenDreambox: DVB API v3 Dependencies"
RDEPENDS_${PN} = "\
  dvbsnoop \
  dreambox-dvb-tools-v3 \
  dvbtraffic \
  sctzap \
"

