package com.company.myapplication1;
// ChatbotFragment.java

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ChatbotFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText etMessage;
    private ImageButton btnSend;
    private ChatAdapter adapter;
    private List<ChatMessage> chatMessages;

    public ChatbotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatbot, container, false);

        recyclerView = view.findViewById(R.id.recycler_chat);
        etMessage = view.findViewById(R.id.et_message);
        btnSend = view.findViewById(R.id.btn_send);

        // Setup chat recycler view
        chatMessages = new ArrayList<>();
        adapter = new ChatAdapter(chatMessages);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Add welcome message
        chatMessages.add(new ChatMessage("Hello! I'm your Ayurvedic assistant. How can I help you today?", false));
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(chatMessages.size() - 1);

        // Send button click listener
        btnSend.setOnClickListener(v -> {
            String message = etMessage.getText().toString().trim();
            if (!message.isEmpty()) {
                // Add user message
                chatMessages.add(new ChatMessage(message, true));
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(chatMessages.size() - 1);

                // Clear input
                etMessage.setText("");

                // Simulate AI response (replace with actual API call)
                simulateAIResponse(message);
            }
        });

        return view;
    }

    private void simulateAIResponse(String userMessage) {
        // Simulate delay for AI response
        new android.os.Handler().postDelayed(
                () -> {
                    String response;

                    if (userMessage.toLowerCase().contains("diet") || userMessage.toLowerCase().contains("food")) {
                        response = "Based on your Vata-Pitta prakriti, I recommend warm, cooked foods with a balance of sweet, sour, and salty tastes.";
                    } else if (userMessage.toLowerCase().contains("dosha")) {
                        response = "Your prakriti assessment shows a Vata-Pitta constitution. This means you have qualities of both air and fire elements.";
                    } else if (userMessage.toLowerCase().contains("recipe")) {
                        response = "Here's a balancing recipe for you: Kitchari - a mixture of rice, mung dal, and spices that's tridoshic.";
                    } else {
                        response = "I understand you're asking about: " + userMessage + ". For personalized advice, please consult with your Ayurvedic doctor.";
                    }

                    chatMessages.add(new ChatMessage(response, false));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(chatMessages.size() - 1);
                },
                1000 // 1 second delay
        );
    }
}