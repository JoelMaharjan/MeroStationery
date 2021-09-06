

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.Joel.merostationery.R
import com.bumptech.glide.Glide
import com.Joel.merostationery.Booking
import com.Joel.merostationery.Repository.VegRepo
import com.Joel.merostationery.api.ServiceBuilder
import com.Joel.merostationery.books

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookingAdapter(val context: Context,val lst:MutableList<Booking>):RecyclerView.Adapter<BookingAdapter.BookingHolder>() {

    class BookingHolder(view: View):RecyclerView.ViewHolder(view){


        val image:ImageView = view.findViewById(R.id.imageView)
        val name:TextView = view.findViewById(R.id.name)
        val qty:TextView = view.findViewById(R.id.qty)
        val price:TextView = view.findViewById(R.id.price)
        val plus:TextView = view.findViewById(R.id.plus)
        val minus:TextView = view.findViewById(R.id.minus)
        val delete:ImageButton = view.findViewById(R.id.delete)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cart, parent, false)
        return  BookingHolder(view)
    }

    override fun onBindViewHolder(holder: BookingHolder, position: Int) {

        val booking =lst[position]
        holder.name.text = booking.Vegetables!!.Name
        holder.price.text = (booking.Vegetables!!.Price!!).toString()
        holder.qty.text = booking.Qty.toString()
        Glide.with(context).load("${ServiceBuilder.BASE_URL}images/${booking.Vegetables.Image}").into(holder.image)
        holder.plus.setOnClickListener(){

            val qtys = holder.qty.text.toString().toInt()+1
            holder.qty.text = qtys.toString()
            holder.price.text = (booking.Vegetables!!.Price!!.toInt()*qtys).toString()

            CoroutineScope(Dispatchers.IO).launch {

                val repo = VegRepo()

                val response = repo.update(booking._id!!, books(qtys))


            }


        }
        holder.minus.setOnClickListener(){
            val qtys = holder.qty.text.toString().toInt()-1
            holder.qty.text = qtys.toString()
            holder.price.text = (booking.Vegetables!!.Price!!.toInt()*qtys).toString()

            CoroutineScope(Dispatchers.IO).launch {

                val repo = VegRepo()
                val response = repo.update(booking._id!!, books(qtys))



            }


        }
        holder.delete.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {

                val repo = VegRepo()
                val response = repo.delete(booking._id!!)
                withContext(Main){
//                    Notify()
                    Toast.makeText(context, "One item Deleted", Toast.LENGTH_SHORT).show()
                    lst.removeAt(position)
                    notifyDataSetChanged()
                }

            }



        }

    }

    override fun getItemCount(): Int {
        return lst.size
    }





//    fun Notify(){
//
//        val notificationManager= NotificationManagerCompat.from(context)
//        val notificationChannels  = Notification(context)
//        notificationChannels.createNotification()
//        val notification = NotificationCompat.Builder(context,notificationChannels.c1)
//
//            .setSmallIcon(R.drawable.ic_baseline_add_shopping_cart_24)
//            .setContentTitle("Deleted").setNotificationSilent().setNotificationSilent().setNotificationSilent()
//            .setContentTitle("One Item Deleted").setColor(Color.BLUE).build()
//        notificationManager.notify(1,notification)
//    }

}

