using TestProject1;
using static TestProject1.Program;
namespace ConsoleAppTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string filePath = "../../../../TestProject1/keystone-throughput-and-capacity.csv";
            List<Record> records = ReadCsv(filePath);
            DisplayRecords(records);
            Console.WriteLine("Nouraldin Hassan");
            Console.ReadKey();
        }
    }
}
