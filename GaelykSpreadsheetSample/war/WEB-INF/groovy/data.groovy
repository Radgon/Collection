import java.net.URLConnection;

def labels = ["A", "B", "C", "D", "E"]
int ivalue = new Random().nextInt(5);

String link;
if (memcacheService.get(labels.get(ivalue)) == null) {
	def ts = new com.commons.gse.TestSheets();
	link = ts.getData(labels.get(ivalue)); 
	memcacheService.put(labels.get(ivalue), link)
} else {
	link = memcacheService.get(labels.get(ivalue))
}
request.setAttribute ('counter', com.commons.gse.TestSheets.counter++)
request.setAttribute ('appendix', link)
forward '/data.gtpl'

