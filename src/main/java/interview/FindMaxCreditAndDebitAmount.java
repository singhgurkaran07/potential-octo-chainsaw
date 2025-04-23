package interview;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindMaxCreditAndDebitAmount {

    public static void main(String[] args) {
        maximumTransfer("Bob Martin", "Bourg");
    }

    public static List<String> maximumTransfer(String name, String city) {
        List<String> resultList = new ArrayList<>();
        String baseUrlString = "https://jsonmock.hackerrank.com/api/transactions";
        List<TransactionInfo> transactionInfos = fetchAllTransactions(baseUrlString);
        /*transactionInfos.forEach(txn ->
                System.out.println("Username : "+ txn.userName + "City : "+ txn.location.city));
*/
        List<TransactionInfo> filterTxnsByNameAndCity = transactionInfos.stream()
                .filter(txn -> txn.userName.equalsIgnoreCase(name) && city.equalsIgnoreCase(txn.location.city)).collect(Collectors.toList());

        //System.out.println(filterTxnsByNameAndCity);

        double maxCredit = filterTxnsByNameAndCity.stream().filter(txn -> txn.txnType.equals("credit")).mapToDouble(txn -> Double.parseDouble(txn.amount.replaceAll("[^\\d.]", ""))).max().orElse(0);

        double maxDebit = filterTxnsByNameAndCity.stream().filter(txn -> txn.txnType.equals("debit")).mapToDouble(txn -> Double.parseDouble(txn.amount.replaceAll("[^\\d.]", ""))).max().orElse(0);

        resultList.add(String.format("%.2f", maxCredit));
        resultList.add(String.format("%.2f", maxDebit));

        System.out.println(resultList);

        return resultList;
    }

    private static List<TransactionInfo> fetchAllTransactions(String baseUrl) {
        List<TransactionInfo> allTransactions = new ArrayList<>();
        int currentPage = 1;

        while (true) {
            String url = baseUrl + "?page=" + currentPage;
            PaginatedResponse response = fetchPaginatedData(url);

            if (response == null || response.data == null || response.data.isEmpty()) {
                break;
            }

            allTransactions.addAll(response.data);

            // Break loop if we have fetched all pages
            if (currentPage >= response.total_pages) {
                break;
            }

            currentPage++;
        }

        return allTransactions;
    }

    static PaginatedResponse fetchPaginatedData(String url) {
        try{
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject object = JsonParser.parseString(response.body()).getAsJsonObject();
            //System.out.println(object.toString());

            Gson gson = new Gson();
            return gson.fromJson(object,PaginatedResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new PaginatedResponse();
        }
    }



    static class PaginatedResponse {
        int page;
        int per_page;
        int total;
        public int total_pages;
        List<TransactionInfo> data;
    }
    static class TransactionInfo {
        int id;
        int userId;
        String userName;
        long timestamp;
        String txnType;
        String amount;
        Location location;
        String ip;

        static class Location {
            int id;
            String address;
            String city;
            String zipCode;
        }
    }

}
