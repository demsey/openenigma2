DESCRIPTION = "IPC::ShareLite - Light-weight interface to shared memory"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MAURICE/IPC-ShareLite-${PV}.tar.gz"

S = "${WORKDIR}/IPC-ShareLite-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/IPC/ShareLite/* \
                ${libdir}/perl5/*/*/auto/IPC/ShareLite/.packlist \
                ${libdir}/perl5/*/*/IPC"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/IPC/ShareLite/.debug"